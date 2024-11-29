package com.faith.theads;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

class DownloadingHeartBeat extends Thread {
    private volatile boolean beating = true;

    public void shutdown(){
        this.beating = false;
    }
    @Override
    public void run() {
        String[] dots = {
          ".",
          "..",
          "...",
          "...."
        };
        while (beating) {
            for (String dot : dots) {
                System.out.println(dot);
                try {
                    Thread.sleep(50);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

class FileDownloader extends Thread {
    private String url;
    private String fileName;

    public FileDownloader(String url, String fileName) {
        this.url = url;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        try {
            System.out.println("Started to download " + fileName);
            URL resourceToDownload = new URL(url);
            URLConnection connection = resourceToDownload.openConnection();
            InputStream input = connection.getInputStream();

            File fileToSave = new File(fileName);
            Files.copy(input,fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
            input.close();
        } catch (IOException e){
            System.out.println("Failed to download the file: " + e.getMessage());
        }
    }
}

public class ThreadJoinExample {
    public static void main(String[] args) {
        FileDownloader dl1 = new FileDownloader("https://goo.gl/nqZJn4", "jugbd-meetup7_1.jpeg");
        FileDownloader dl2 = new FileDownloader("https://goo.gl/UoSMMt", "jugbd-meetup7_2.jpeg");

        DownloadingHeartBeat heartBeat = new DownloadingHeartBeat();

        dl1.start();
        dl2.start();
        heartBeat.start();

        try {
            dl1.join();
            dl2.join();
            heartBeat.shutdown();
            heartBeat.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("\nThe Download is complete");
    }
}

