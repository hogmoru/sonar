/*
 * Sonar, open source software quality management tool.
 * Copyright (C) 2008-2012 SonarSource
 * mailto:contact AT sonarsource DOT com
 *
 * Sonar is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * Sonar is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Sonar; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.plugins.core.timemachine;

import org.sonar.api.measures.CoreMetrics;
import org.sonar.api.measures.Metric;
import org.sonar.batch.components.TimeMachineConfiguration;

public class NewOverallCoverageFileAnalyzer extends AbstractNewCoverageFileAnalyzer {

  public NewOverallCoverageFileAnalyzer(TimeMachineConfiguration timeMachineConfiguration) {
    super(timeMachineConfiguration);
  }

  @Override
  public Metric getCoverageLineHitsDataMetric() {
    return CoreMetrics.OVERALL_COVERAGE_LINE_HITS_DATA;
  }

  @Override
  public Metric getConditionsByLineMetric() {
    return CoreMetrics.OVERALL_CONDITIONS_BY_LINE;
  }

  @Override
  public Metric getCoveredConditionsByLineMetric() {
    return CoreMetrics.OVERALL_COVERED_CONDITIONS_BY_LINE;
  }

  @Override
  public Metric getNewLinesToCoverMetric() {
    return CoreMetrics.NEW_OVERALL_LINES_TO_COVER;
  }

  @Override
  public Metric getNewUncoveredLinesMetric() {
    return CoreMetrics.NEW_OVERALL_UNCOVERED_LINES;
  }

  @Override
  public Metric getNewConditionsToCoverMetric() {
    return CoreMetrics.NEW_OVERALL_CONDITIONS_TO_COVER;
  }

  @Override
  public Metric getNewUncoveredConditionsMetric() {
    return CoreMetrics.NEW_OVERALL_UNCOVERED_CONDITIONS;
  }
}
