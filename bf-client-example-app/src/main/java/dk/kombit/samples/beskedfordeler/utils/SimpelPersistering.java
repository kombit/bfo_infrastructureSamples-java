package dk.kombit.samples.beskedfordeler.utils;

import java.io.File;
import java.io.FileWriter;

import dk.kombit.bf.beskedkuvert.HaendelsesbeskedType;

/**
 * Simple class for persisting an XML document into a file
 */
public class SimpelPersistering {
    /**
     * Writes a {@link HaendelsesbeskedType} to a file using a {@link FileWriter} instance
     * @param haendelsesbesked instance of {@link HaendelsesbeskedType} to serialize
     * @param filename name of file to serialize to
     * @throws Exception thrown if errors occur
     */
    public static void persistMessage(HaendelsesbeskedType haendelsesbesked, String filename) throws Exception {
        File file = new File(filename);
        boolean append = true;
        SamplesHelper.marshal(haendelsesbesked, new FileWriter(file, append), SamplesHelper.HAENDELSESBESKED_QNAME);
    }

}
