/*
 * Copyright (c) 2008-2020, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hazelcast.collection.impl.queue.model;

import java.io.Serializable;
import java.util.Comparator;

public class PriorityElementComparator implements Comparator<PriorityElement>, Serializable {

    private static final long serialVersionUID = 1L;

    @Override
    public int compare(PriorityElement o1, PriorityElement o2) {
        if (o1.isHighPriority() && !o2.isHighPriority()) {
            return -1;
        }
        if (o2.isHighPriority() && !o1.isHighPriority()) {
            return 1;
        }
        return o1.getVersion().compareTo(o2.getVersion());
    }

    @Override
    public final boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        return getClass().equals(o.getClass());
    }

    @Override
    public final int hashCode() {
        return getClass().hashCode();
    }

}
