package com.yausername.youtubedl_android;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class YoutubeDLRequest {

    private final List<String> urls;
    private final YoutubeDLOptions options = new YoutubeDLOptions();

    private final List<String> commandList = new ArrayList<>();

    public YoutubeDLRequest(String url) {
        this.urls = Arrays.asList(url);
    }

    public YoutubeDLRequest(@NonNull List<String> urls) {
        this.urls = urls;
    }

    public YoutubeDLRequest addOption(@NonNull String option, @NonNull String argument) {
        options.addOption(option, argument);
        return this;
    }

    public YoutubeDLRequest addOption(@NonNull String option, @NonNull Number argument) {
        options.addOption(option, argument);
        return this;
    }

    public YoutubeDLRequest addOption(String option) {
        options.addOption(option);
        return this;
    }

    public YoutubeDLRequest addCommands(List<String> commands) {
        commandList.addAll(commands);
        return this;
    }

    public String getOption(String option) {
        return options.getArgument(option);
    }

    public List<String> getArguments(String option) {
        return options.getArguments(option);
    }

    public boolean hasOption(String option) {
        return options.hasOption(option);
    }

    public List<String> buildCommand() {
        commandList.addAll(urls);
        commandList.addAll(options.buildOptions());
        return commandList;
    }

}
