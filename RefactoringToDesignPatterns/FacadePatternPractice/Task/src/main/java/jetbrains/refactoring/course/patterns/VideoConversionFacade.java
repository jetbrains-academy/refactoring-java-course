package jetbrains.refactoring.course.patterns;

import jetbrains.refactoring.course.patterns.video.EncodedVideo;
import jetbrains.refactoring.course.patterns.video.ProcessedVideo;
import jetbrains.refactoring.course.patterns.video.Video;

public class VideoConversionFacade {
    private final VideoLoader videoLoader = new VideoLoader();
    private final VideoProcessor videoProcessor = new VideoProcessor();
    private final VideoEncoder videoEncoder = new VideoEncoder();
    private final VideoSaver videoSaver = new VideoSaver();

    public void convertVideo(String originalVideoName, String processedVideoName) {
        Video video = videoLoader.loadVideo(originalVideoName);
        ProcessedVideo processedVideo = videoProcessor.processVideo(video);
        EncodedVideo encodedVideo = videoEncoder.encodeVideo(processedVideo);
        videoSaver.saveVideo(encodedVideo, processedVideoName);
    }
}
