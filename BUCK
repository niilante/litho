# Copyright (c) 2017-present, Facebook, Inc.
# All rights reserved.
#
# This source code is licensed under the BSD-style license found in the
# LICENSE file in the root directory of this source tree. An additional grant
# of patent rights can be found in the PATENTS file in the same directory.

import os

include_defs("//COMPONENTS_DEFS")

litho_android_library(
    name = "components",
    exported_deps = [
        COMPONENTS_STETHO_JAVA_TARGET,
        COMPONENTS_JAVA_TARGET,
        COMPONENTS_ANDROIDSUPPORT_TARGET,
        COMPONENTS_YOGA_TARGET,
    ],
    visibility = [
        "PUBLIC",
    ],
    deps = [
        COMPONENTS_BUILD_CONFIG_TARGET,
    ],
)

litho_android_library(
    name = "sections",
    exported_deps = [
        ":components",
        COMPONENTS_SECTIONS_TARGET,
        COMPONENTS_SECTIONS_ANNOTATIONS_TARGET,
    ],
    visibility = [
        "PUBLIC",
    ],
)

android_resource(
    name = "res",
    package = "com.facebook.litho",
    res = "litho-core/src/main/res",
    visibility = [
        "PUBLIC",
    ],
    deps = [
    ],
)

android_build_config(
    name = "build_config",
    package = "com.facebook.litho",
    values_file = ":build_config_values",
    visibility = COMPONENTS_VISIBILITY,
)

genrule(
    name = "build_config_values",
    srcs = [
        "config/build_config_values",
    ],
    out = "extra_build_config_values",
    cmd = "SRCARR=($SRCS); cat ${SRCARR[0]} | sed 's/{{IS_DEBUG}}/%s/' > $OUT" % (os.environ.get("LITHO_IS_DEBUG", "true")),
)
