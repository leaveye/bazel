// Copyright 2014 Google Inc. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.devtools.build.lib.rules.cpp;

import com.google.common.collect.Iterables;
import com.google.devtools.build.lib.concurrent.ThreadSafety.Immutable;
import com.google.devtools.build.lib.view.TransitiveInfoProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A provider for cc_public_library rules to be able to convey the information about the
 * header target's module map references to the public library target.
 */
@Immutable
public final class HeaderTargetModuleMapProvider implements TransitiveInfoProvider {

  private final List<CppModuleMap> cppModuleMaps;

  public HeaderTargetModuleMapProvider(Iterable<CppModuleMap> cppModuleMaps) {
    ArrayList<CppModuleMap> cppModulesMapsAsList = new ArrayList<>();
    Iterables.addAll(cppModulesMapsAsList, cppModuleMaps);
    this.cppModuleMaps = Collections.unmodifiableList(cppModulesMapsAsList);
  }

  /**
   * Returns the module maps referenced by cc_public_library's headers target. The list might
   * contain null elements.
   */
  public List<CppModuleMap> getCppModuleMaps() {
    return cppModuleMaps;
  }
}