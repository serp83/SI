import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;


public class Parser {
    public static String data = "{\"#\",acf6192e-81ca-46ef-93a6-5a6968b78663,{8,{2,{0,\"Колонка1\",{\"Pattern\"},\"\",0},{1,\"Колонка2\",{\"Pattern\"},\"\",0}},{2,2,0,0,1,1,{1,2,{2,0,2,{\"N\",1},{\"N\",2},0},{2,1,2,{\"N\",2},{\"N\",1},0}},1,1}}}";

    public static String ddata = "схрюша";

    public static void main_(String[] args) {

        // Generate input string and the ByteBuffer for it
        String stringToInsert = "This is a string to insert into a file.";
        byte[] answerByteArray = stringToInsert.getBytes();
        ByteBuffer byteBuffer = ByteBuffer.wrap(answerByteArray);

        File fileToModify = new File("/path/to/file");

        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile(fileToModify, "rw");
        } catch (FileNotFoundException e1) {
            // TODO error handling and logging
        }

        FileChannel outputFileChannel = randomAccessFile.getChannel();

        // Move to the beginning of the file and write out the contents
        // of the byteBuffer.
        try {
            outputFileChannel.position(0);

            while (byteBuffer.hasRemaining()) {
                outputFileChannel.write(byteBuffer);

            }
        } catch (IOException e) {
            // TODO error handling and logging
        }

        try {
            outputFileChannel.close();
        } catch (IOException e) {
            // TODO error handling and logging
        }

        try {
            randomAccessFile.close();
        } catch (IOException e) {
            // TODO error handling and logging
        }
    }

    public static void main_() {
        List<? super String> d = new ArrayList<>();
        d.add("sdf");
    }

    public static List<String> getToDos() {
        List<String> res = new ArrayList<>();
        res.add("1");
        res.add("2");
        res.add("3");
        return res;
    }

    public static void main(String[] args) {

        Function<Integer, String> IntegerToString = new Function<Integer, String>() {
            @Override
            public String apply(Integer s) throws Exception {
                return String.valueOf(s) + "************";
            }

        };

        Function<String, Integer> stringToInteger = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) throws Exception {
                return Integer.valueOf(s);
            }

        };

        Observable<String> todoObservable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                try {
                    List<String> todos = getToDos();
                    for (String todo : todos) {
                        emitter.onNext(todo);
                    }
                    emitter.onComplete();
                } catch (Exception e) {
                    emitter.onError(e);
                }
            }
        }).map(stringToInteger).map(IntegerToString);

        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("onSubscribe ");
            }

            @Override
            public void onNext(String s) {
                System.out.println("onNext: " + s);
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("onError: " + e);
            }

            @Override
            public void onComplete() {

            }
        };


        todoObservable.subscribe(observer);

//        Observable<String> observable = Observable..from(new String[]{"one", "two", "three"});
    }
}
