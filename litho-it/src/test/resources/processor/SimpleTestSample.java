/*
 * Copyright (c) 2017-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

package com.facebook.litho.processor.integration.resources;

import com.facebook.litho.ComponentContext;
import com.facebook.litho.ResourceResolver;
import com.facebook.litho.testing.assertj.ComponentMatcher;
import com.facebook.litho.testing.subcomponents.InspectableComponent;

/**
 *
 * @see com.facebook.litho.processor.integration.resources.SimpleTestSampleSpec
 */
public final class SimpleTestSample implements SimpleTestSampleSpec {
  public static Matcher matcher(ComponentContext c) {
    return new Matcher(c);
  }

  public static class Matcher extends ResourceResolver {
    Matcher(ComponentContext c) {
      super.init(c, c.getResourceCache());
    }

    public ComponentMatcher build() {
      return new ComponentMatcher() {
        @Override
        public boolean matches(InspectableComponent value) {
          if (!value.getComponentClass().isAssignableFrom(com.facebook.litho.processor.integration.resources.SimpleLayout.class)) {
            return false;
          }
          final com.facebook.litho.processor.integration.resources.SimpleLayout impl = (com.facebook.litho.processor.integration.resources.SimpleLayout) value.getComponent();
          return true;
        }
      };
    }
  }
}
