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
package org.sonar.api.resources;

import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class LanguagesTest {
  @Test
  public void should_add_several_times_the_same_language() {
    Languages languages = new Languages(
        language("fake"),
        language("fake"));

    assertThat(languages.get("fake").getKey()).isEqualTo("fake");
  }

  @Test
  public void should_get_suffixes() {
    Languages languages = new Languages(
        language("java", "java"),
        language("php", "php4", "php5"));

    assertThat(languages.getSuffixes()).containsOnly("java", "php4", "php5");
    assertThat(languages.getSuffixes("java")).containsOnly("java");
    assertThat(languages.getSuffixes("php")).containsOnly("php4", "php5");
    assertThat(languages.getSuffixes("xxx")).isEmpty();
  }

  static Language language(String key, String... suffixes) {
    Language lang = mock(Language.class);
    when(lang.getKey()).thenReturn(key);
    when(lang.getFileSuffixes()).thenReturn(suffixes);
    return lang;
  }
}
