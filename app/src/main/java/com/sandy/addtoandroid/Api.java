package com.sandy.addtoandroid;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;

/**
 * Generated class from Pigeon.
 */
@SuppressWarnings(
        {"unused", "unchecked", "CodeBlock2Expr", "RedundantSuppression"})
public class Api {

    /**
     * Generated class from Pigeon that represents data sent in messages.
     */
    public static class Book {
        private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String setterArg) {
            this.title = setterArg;
        }

        private String subtitle;

        public String getSubtitle() {
            return subtitle;
        }

        public void setSubtitle(String setterArg) {
            this.subtitle = setterArg;
        }

        private String author;

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String setterArg) {
            this.author = setterArg;
        }

        private String summary;

        public String getSummary() {
            return summary;
        }

        public void setSummary(String setterArg) {
            this.summary = setterArg;
        }

        private String publishDate;

        public String getPublishDate() {
            return publishDate;
        }

        public void setPublishDate(String setterArg) {
            this.publishDate = setterArg;
        }

        private Long pageCount;

        public Long getPageCount() {
            return pageCount;
        }

        public void setPageCount(Long setterArg) {
            this.pageCount = setterArg;
        }

        private Thumbnail thumbnail;

        public Thumbnail getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(Thumbnail setterArg) {
            this.thumbnail = setterArg;
        }

        Map<String, Object> toMap() {
            Map<String, Object> toMapResult = new HashMap<>();
            toMapResult.put("title", title);
            toMapResult.put("subtitle", subtitle);
            toMapResult.put("author", author);
            toMapResult.put("summary", summary);
            toMapResult.put("publishDate", publishDate);
            toMapResult.put("pageCount", pageCount);
            toMapResult.put("thumbnail",
                    (thumbnail == null) ? null : thumbnail.toMap());
            return toMapResult;
        }

        static Book fromMap(Map<String, Object> map) {
            Book fromMapResult = new Book();
            Object title = map.get("title");
            fromMapResult.title = (String) title;
            Object subtitle = map.get("subtitle");
            fromMapResult.subtitle = (String) subtitle;
            Object author = map.get("author");
            fromMapResult.author = (String) author;
            Object summary = map.get("summary");
            fromMapResult.summary = (String) summary;
            Object publishDate = map.get("publishDate");
            fromMapResult.publishDate = (String) publishDate;
            Object pageCount = map.get("pageCount");
            fromMapResult.pageCount =
                    (pageCount == null)
                            ? null
                            : ((pageCount instanceof Integer) ? (Integer) pageCount
                            : (Long) pageCount);
            Object thumbnail = map.get("thumbnail");
            fromMapResult.thumbnail = Thumbnail.fromMap((Map) thumbnail);
            return fromMapResult;
        }
    }

    /**
     * Generated class from Pigeon that represents data sent in messages.
     */
    public static class Thumbnail {
        private String url;

        public String getUrl() {
            return url;
        }

        public void setUrl(String setterArg) {
            this.url = setterArg;
        }

        Map<String, Object> toMap() {
            Map<String, Object> toMapResult = new HashMap<>();
            toMapResult.put("url", url);
            return toMapResult;
        }

        static Thumbnail fromMap(Map<String, Object> map) {
            Thumbnail fromMapResult = new Thumbnail();
            Object url = map.get("url");
            fromMapResult.url = (String) url;
            return fromMapResult;
        }
    }

    private static class FlutterBookApiCodec extends StandardMessageCodec {
        public static final FlutterBookApiCodec INSTANCE =
                new FlutterBookApiCodec();

        private FlutterBookApiCodec() {
        }

        @Override
        protected Object readValueOfType(byte type, ByteBuffer buffer) {
            switch (type) {
                case (byte) 128:
                    return Book.fromMap((Map<String, Object>) readValue(buffer));

                default:
                    return super.readValueOfType(type, buffer);
            }
        }

        @Override
        protected void writeValue(ByteArrayOutputStream stream, Object value) {
            if (value instanceof Book) {
                stream.write(128);
                writeValue(stream, ((Book) value).toMap());
            } else {
                super.writeValue(stream, value);
            }
        }
    }

    /**
     * Generated class from Pigeon that represents Flutter messages that can be
     * called from Java.
     */
    public static class FlutterBookApi {
        private final BinaryMessenger binaryMessenger;

        public FlutterBookApi(BinaryMessenger argBinaryMessenger) {
            this.binaryMessenger = argBinaryMessenger;
        }

        public interface Reply<T> {
            void reply(T reply);
        }

        static MessageCodec<Object> getCodec() {
            return FlutterBookApiCodec.INSTANCE;
        }

        public void displayBookDetails(Book bookArg, Reply<Void> callback) {
            BasicMessageChannel<Object> channel = new BasicMessageChannel<>(
                    binaryMessenger,
                    "dev.flutter.pigeon.FlutterBookApi.displayBookDetails", getCodec());
            channel.send(new ArrayList<Object>(Arrays.asList(bookArg)),
                    channelReply -> {
                        callback.reply(null);
                    });
        }
    }

    private static class HostBookApiCodec extends StandardMessageCodec {
        public static final HostBookApiCodec INSTANCE = new HostBookApiCodec();

        private HostBookApiCodec() {
        }

        @Override
        protected Object readValueOfType(byte type, ByteBuffer buffer) {
            switch (type) {
                case (byte) 128:
                    return Book.fromMap((Map<String, Object>) readValue(buffer));

                default:
                    return super.readValueOfType(type, buffer);
            }
        }

        @Override
        protected void writeValue(ByteArrayOutputStream stream, Object value) {
            if (value instanceof Book) {
                stream.write(128);
                writeValue(stream, ((Book) value).toMap());
            } else {
                super.writeValue(stream, value);
            }
        }
    }

    /**
     * Generated interface from Pigeon that represents a handler of messages from
     * Flutter.
     */
    public interface HostBookApi {
        void cancel();

        void finishEditingBook(Book book);

        /**
         * The codec used by HostBookApi.
         */
        static MessageCodec<Object> getCodec() {
            return HostBookApiCodec.INSTANCE;
        }

        /**
         * Sets up an instance of `HostBookApi` to handle messages through the
         * `binaryMessenger`.
         */
        static void setup(BinaryMessenger binaryMessenger, HostBookApi api) {
            {
                BasicMessageChannel<Object> channel = new BasicMessageChannel<>(
                        binaryMessenger, "dev.flutter.pigeon.HostBookApi.cancel",
                        getCodec());
                if (api != null) {
                    channel.setMessageHandler((message, reply) -> {
                        Map<String, Object> wrapped = new HashMap<>();
                        try {
                            api.cancel();
                            wrapped.put("result", null);
                        } catch (Error | RuntimeException exception) {
                            wrapped.put("error", wrapError(exception));
                        }
                        reply.reply(wrapped);
                    });
                } else {
                    channel.setMessageHandler(null);
                }
            }
            {
                BasicMessageChannel<Object> channel = new BasicMessageChannel<>(
                        binaryMessenger, "dev.flutter.pigeon.HostBookApi.finishEditingBook",
                        getCodec());
                if (api != null) {
                    channel.setMessageHandler((message, reply) -> {
                        Map<String, Object> wrapped = new HashMap<>();
                        try {
                            ArrayList<Object> args = (ArrayList<Object>) message;
                            Book bookArg = (Book) args.get(0);
                            if (bookArg == null) {
                                throw new NullPointerException("bookArg unexpectedly null.");
                            }
                            api.finishEditingBook(bookArg);
                            wrapped.put("result", null);
                        } catch (Error | RuntimeException exception) {
                            wrapped.put("error", wrapError(exception));
                        }
                        reply.reply(wrapped);
                    });
                } else {
                    channel.setMessageHandler(null);
                }
            }
        }
    }

    private static Map<String, Object> wrapError(Throwable exception) {
        Map<String, Object> errorMap = new HashMap<>();
        errorMap.put("message", exception.toString());
        errorMap.put("code", exception.getClass().getSimpleName());
        errorMap.put("details", null);
        return errorMap;
    }
}