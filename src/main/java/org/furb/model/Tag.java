package org.furb.model;

public class Tag implements Comparable<Tag> {
    private int frequency;
    private final String content;

    public Tag(String content) {
        this.content = content;
    }

    public boolean isValidTag() {
        return content.startsWith("<") && content.endsWith(">") && !content.startsWith("< ");
    }

    public boolean isFinal() {
        return content.startsWith("</");
    }

    public String getContent() {
        return content;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public boolean isSingleton() {
        for (SingletonTags tag : SingletonTags.values()) {
            if (tag.getContent().equals(content)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Tag o) {
        return Integer.compare(o.frequency, this.frequency);
    }

    @Override
    public boolean equals(Object obj) {
        return this.content.equals(((Tag) obj).content);
    }

    public enum SingletonTags {
        BR("<br>"),
        IMG("<img>"),
        INPUT("<input>"),
        META("<meta>"),
        LINK("<link>"),
        HR("<hr>"),
        COL("<col>"),
        COMMAND("<command>"),
        EMBED("<embed>"),
        PARAM("<param>"),
        SOURCE("<source>"),
        DOCTYPE("<!DOCTYPE>");

        private final String content;

        SingletonTags(String content) {
            this.content = content;
        }

        public String getContent() {
            return content;
        }
    }

}
