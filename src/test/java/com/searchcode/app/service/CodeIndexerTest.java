package com.searchcode.app.service;

import com.searchcode.app.dto.CodeIndexDocument;
import junit.framework.TestCase;
import org.apache.commons.lang3.RandomStringUtils;
import org.eclipse.jetty.util.ConcurrentArrayQueue;

import java.io.IOException;
import java.util.Queue;
import java.util.Random;

public class CodeIndexerTest extends TestCase {
    public CodeIndexDocument codeIndexDocument = new CodeIndexDocument("repoLocationRepoNameLocationFilename", "repoName", "fileName", "fileLocation", "fileLocationFilename", "md5hash", "languageName", 100, "contents", "repoRemoteLocation", "codeOwner");

    public void testIndexDocument() throws IOException {
        CodeIndexer.indexDocument(codeIndexDocument);
    }

    // TODO actually assert something in here
    public void testIndexDocuments() throws IOException {
        Queue<CodeIndexDocument> queue = new ConcurrentArrayQueue<>();
        queue.add(codeIndexDocument);
        CodeIndexer.indexDocuments(queue);
    }

    // TODO actually assert something in here
    public void testDeleteByRepoName() throws IOException {
        CodeIndexer.deleteByReponame("repoName");
    }

    // TODO actually assert something in here
    public void testDeleteByFileLocationFilename() throws IOException {
        CodeIndexer.deleteByFileLocationFilename("fileLocationFilename");
    }

    // TODO fix the assert rather then programming by exception
    public void testIndexDocumentsEmptyIssue() {
        try {
            CodeIndexDocument cid = new CodeIndexDocument("repoLocationRepoNameLocationFilename", "", "fileName", "fileLocation", "fileLocationFilename", "md5hash", "languageName", 0, null, "repoRemoteLocation", "codeOwner");

            Queue queue = new ConcurrentArrayQueue<CodeIndexDocument>();
            queue.add(cid);

            CodeIndexer.indexDocuments(queue);
        }
        catch(Exception ex) {
            assertTrue(false);
        }
    }

    // TODO expand on these tests
//    public void testIndexTimeDocuments() {
//        try {
//            Random rand = new Random();
//
//            String contents = "this is some code that should be found";
//
//            for (int j=0; j < 1000; j++) {
//                contents += " " + RandomStringUtils.randomAlphabetic(rand.nextInt(10) + 1);
//            }
//
//            CodeIndexDocument cid = new CodeIndexDocument("repoLocationRepoNameLocationFilename", "", "fileName", "fileLocation", "fileLocationFilename", "md5hash", "languageName", 0, contents, "repoRemoteLocation", "codeOwner");
//            cid.setRevision("99a5a271063def87b2473be79ce6f840d42d1f95");
//            cid.setYearMonthDay("20160101");
//
//            Queue queue = new ConcurrentArrayQueue<CodeIndexDocument>();
//            queue.add(cid);
//
//            CodeIndexer.indexTimeDocuments(queue);
//        }
//        catch(Exception ex) {
//            assertTrue(false);
//        }
//    }
}
