// copied from apache-crunch-0.9.0
/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.solr.crunch;

import org.apache.crunch.impl.mr.run.RuntimeParameters;
import org.apache.crunch.test.TemporaryPath;
import org.apache.hadoop.conf.Configuration;


/**
 * Utilities for working with {@link TemporaryPath}.
 */
final class TemporaryPaths {

  /**
   * Static factory returning a {@link TemporaryPath} with adjusted
   * {@link Configuration} properties.
   */
  public static TemporaryPath create() {
    return new TemporaryPath(RuntimeParameters.TMP_DIR, "hadoop.tmp.dir");
  }

  private TemporaryPaths() {
    // nothing
  }
}
