#!/usr/bin/env groovy
/**
 * Run some simple functional tests on backup script
 */
class BackupTest extends GroovyTestCase {
    def backup_script = "./PalamidaBackup.groovy"

    def createTestFolder(folder_root) {
        def file = new File(folder_root)
        file.mkdirs()
    }

    void testArgPassing() {
        assertEquals("0 arguments should return 1", 1, "$backup_script".execute().waitFor())
        assertEquals("1 argument  should return 1", 1, "$backup_script src".execute().waitFor())
    }

    void testZipGoodFolder() {
        def src_dir = "./test_src_dir"
        def dst_dir = "./test_dst_dir"
        def archive_file_name = "test-archive.zip"
        def archive_file = new File(dst_dir + File.separator + archive_file_name)

        createTestFolder(src_dir)
        def output = "$backup_script $src_dir $dst_dir $archive_file".execute().text

        // Testing on output seems brittle and pointless, but maybe just
        // during the early development

        // Verify archive file and contents
        assertTrue("Should have an archive file", archive_file.exists())
    }
}

