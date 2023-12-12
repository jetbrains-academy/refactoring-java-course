package jetbrains.refactoring.course.patterns;

import jetbrains.refactoring.course.patterns.video.EncodedVideo;
import jetbrains.refactoring.course.patterns.video.ProcessedVideo;
import jetbrains.refactoring.course.patterns.video.Video;

public class Main {
   public static void main(String[] args) {
      String originalVideoName = args[0];
      String processedVideoName = args[1];

      VideoLoader videoLoader = new VideoLoader();
      VideoProcessor videoProcessor = new VideoProcessor();
      VideoEncoder videoEncoder = new VideoEncoder();
      VideoSaver videoSaver = new VideoSaver();

      Video video = videoLoader.loadVideo(originalVideoName);
      ProcessedVideo processedVideo = videoProcessor.processVideo(video);
      EncodedVideo encodedVideo = videoEncoder.encodeVideo(processedVideo);
      videoSaver.saveVideo(encodedVideo, processedVideoName);
   }
}