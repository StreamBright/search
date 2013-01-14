/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.solr.hadoop.tika;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.hadoop.SolrRecordWriter;
import org.xml.sax.SAXException;


public class Utils {

  public static void validateSolrServerDocumentCount(File solrHomeDir, FileSystem fs, Path outDir, int count)
      throws IOException, ParserConfigurationException, SAXException, SolrServerException {
    
    EmbeddedSolrServer solr = SolrRecordWriter.createEmbeddedSolrServer(
        new Path(solrHomeDir.getAbsolutePath()), fs, new Path(outDir, "part-r-00000"));
    try {
      SolrQuery query = new SolrQuery();
      query.setQuery("*:*");
      QueryResponse resp = solr.query(query);
      assertEquals(count, resp.getResults().getNumFound());
    } finally {
      solr.shutdown();
    }
  }
}