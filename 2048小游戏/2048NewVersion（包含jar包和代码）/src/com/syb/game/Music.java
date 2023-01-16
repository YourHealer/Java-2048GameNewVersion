package com.syb.game;

/**
 * @author ShiYabin
 * @create 2021-12-08 15:52
 * 备注:北京理工大学计算机学院JAVA程序设计结课作业——音乐类
 */

import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;

//音乐类Music
public class Music extends Thread {
    int nBytesRead = 0;
    int EXTERNAL_BUFFER_SIZE = 524288;
    byte[] abData = new byte[EXTERNAL_BUFFER_SIZE];
    private final String fileName;

    public Music(String wavFile) {
        this.fileName = wavFile;
    }

    @SuppressWarnings("unused")
    public void run() {
        // 播放音乐的文件名
        File soundFile = new File(fileName);
        // 如果文件不存在
        if (!soundFile.exists()) {
            System.err.println("Wave file not found:" + fileName);
            return;
        }
        // 设置循环播放
        while (true) {
            // 创建音频输入流对象
            AudioInputStream audioInputStream = null;
            try {
                // 创建音频对象
                audioInputStream = AudioSystem.getAudioInputStream(soundFile);
            } catch (UnsupportedAudioFileException | IOException e1) {
                e1.printStackTrace();
                return;
            }

            // 音频格式
            AudioFormat format = audioInputStream.getFormat();
            // 源数据线
            SourceDataLine auline = null;
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

            try {
                auline = (SourceDataLine) AudioSystem.getLine(info);
                auline.open(format);
            } catch (Exception e) {
                // 捕获异常
                e.printStackTrace();
                return;
            }
            if (auline.isControlSupported(FloatControl.Type.PAN)) {
                FloatControl pan = (FloatControl) auline.getControl(FloatControl.Type.PAN);
            }
            auline.start();

            try {
                while (nBytesRead != -1) {
                    nBytesRead = audioInputStream.read(abData, 0, abData.length);
                    if (nBytesRead >= 0)
                        auline.write(abData, 0, nBytesRead);
                }
            } catch (IOException e) {
                // 捕获异常
                e.printStackTrace();
                return;
            } finally {
                auline.drain();
            }
        }
    }
}