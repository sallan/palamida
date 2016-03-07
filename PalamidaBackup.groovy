#!/usr/bin/env groovy
/**
 * Backup script for Palamida
 */

// Command line arguments?
if (args.length < 2) {
    println "Need a source and destination"
    System.exit(1)
}

PALAMIDA_ROOT_DIR = args[0]
ARCHIVE_ROOT_DIR = args[1]
if (args.length > 2) {
    file_name = args[2]
}
else {
    file_name = "todo.zip"
}

archive_file_name = ARCHIVE_ROOT_DIR + File.separator + file_name

// See if scan is running, if so, quit

// Stop server
// Not sure how well running a bat script will work, as I think it might keep a
// window open. I'll need to experiment with this.

// Here's an example of running a command in windows
//println "cmd /c dir c:\\users\\sallan\\dotfiles".execute().text

// Do a mysql dump and place sql file in PALAMIDA_ROOT_DIR

// Zip up PALAMIDA_ROOT_DIR containing the mysql dump file
// I'm assuming for now the CL will be under PDL or CL, but that
// May not be the case. You should extrace the exact location
// form the conf file.
ant = new AntBuilder()
ant.zip(basedir: PALAMIDA_ROOT_DIR,
        destfile: archive_file_name,
        excludes: "PDL/,CL/")
