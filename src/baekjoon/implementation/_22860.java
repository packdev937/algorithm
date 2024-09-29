package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

// 캐시를 추가해야 함

public class _22860 {

    static class Folder {

        String name;
        List<Folder> subFolders;
        List<File> files;

        public Folder(String name) {
            this.name = name;
            subFolders = new ArrayList<>();
            files = new ArrayList<>();
        }

        public void addSubFolder(Folder folder) {
            subFolders.add(folder);
        }

        public void addFile(File file) {
            files.add(file);
        }

        public List<File> getFiles() {
            List<File> result = new ArrayList<>();
            for (Folder folder : subFolders) {
	result.addAll(folder.getFiles());
            }
            result.addAll(files);
            return result;
        }

        public Set<File> getFileTypes() {
            Set<File> result = new HashSet<>();
            for (Folder folder : subFolders) {
	result.addAll(folder.getFileTypes());
            }
            result.addAll(files);
            return result;
        }
    }

    static class File {

        String name;

        public File(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
	return true;
            }
            File file = (File) o;
            return Objects.equals(name, file.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Folder> folderList = new HashMap<>();
        HashMap<String, File> fileList = new HashMap<>();

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            String mainName = st.nextToken();
            String subName = st.nextToken();
            int type = Integer.parseInt(st.nextToken());

            if (type == 0) {
	Folder folder = getFolder(folderList, mainName);
	File file = getFile(fileList, subName);

	folder.addFile(file);
            } else if (type == 1) {
	Folder folder = getFolder(folderList, mainName);
	Folder subFolder = getFolder(folderList, subName);

	folder.addSubFolder(subFolder);
            }
        }

        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            String[] query = br.readLine().split("/");
            Folder lastFolder = folderList.get(query[query.length - 1]);
            System.out.println(lastFolder.getFileTypes().size() + " " + lastFolder.getFiles().size());
        }
    }

    public static Folder getFolder(HashMap<String, Folder> folderHashMap, String name) {
        if (!folderHashMap.containsKey(name)) {
            Folder newFolder = new Folder(name);
            folderHashMap.put(name, newFolder);
            return newFolder;
        }

        return folderHashMap.get(name);
    }

    public static File getFile(HashMap<String, File> fileHashMap, String name) {
        if (!fileHashMap.containsKey(name)) {
            File newFile = new File(name);
            fileHashMap.put(name, newFile);
            return newFile;
        }

        return fileHashMap.get(name);
    }
}
