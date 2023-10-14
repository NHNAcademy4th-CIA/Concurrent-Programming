package org.nhnacademy.lsj.section5;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 스레드 풀(Thread Pool).
 * Java 스레드 풀은 여러개의 스레드를 만들어두고 만들어 여러번 재사용되는 작업자 스레드 그룹을 나타낸다.
 * <p>
 * 스레드 풀은 고정 크기로 생성된 스레드 풀에 Runnable 객체를 주고 실행을 요청하면, 스레드 풀에서 스레드를 가져와 실행시킨다.
 * <p>
 * 만약 스레드 풀에 남아 있는 스레드가 없다면, 유휴 스레드가 생길때까지 해당 작업은 실행되지 못하고 대기상태에 있게 된다.
 * <p>
 * 실행 중이던 스레드는 작업이 완료되면 다시 스레드 풀로 돌아오게 되고, 대기 중인 작업이 있는 경우 다시 실행하게 된다.
 */
public class MultiFileDownloader {

    /**
     * 스레드 풀을 이용해 여러 파일을 등록하여 다운로드 한다.
     *
     * @param args command line.
     */
    public static void main(String[] args) {
        String[] urls = {"https://nhnacademy.dooray.com/page-files/3481345949028747701",
                "https://nhnacademy.dooray.com/page-files/3481345949029027955",
                "https://nhnacademy.dooray.com/page-files/3481345949033727759",
                "https://nhnacademy.dooray.com/page-files/3481345949034048654",
                "https://nhnacademy.dooray.com/page-files/3481345949034798740",
                "https://nhnacademy.dooray.com/page-files/3481345949034913349"
        };

        ExecutorService executor = Executors.newFixedThreadPool(3);

        for (String url : urls) {
            Runnable worker = new DownloadThread(url);
            executor.execute(worker);
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }

        System.out.println("모든 다운로드가 완료되었습니다.");
    }
}

class DownloadThread implements Runnable {

    private String url;

    public DownloadThread(String url) {
        this.url = url;
    }

    @Override
    public void run() {
        String fileName = url.substring(url.lastIndexOf("/") + 1);
        try {
            URL fileUrl = new URL(url);
            InputStream inputStream = fileUrl.openStream();
            FileOutputStream outputStream = new FileOutputStream(fileName);

            byte[] buffer = new byte[2048];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }

            inputStream.close();
            outputStream.close();

            System.out.println(fileName + " 다운로드 완료");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
