/**
 * Copyright © 2016-2025 The Thingsboard Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.thingsboard.server.dao.model.sql;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import org.thingsboard.server.common.data.DeviceShare;
import org.thingsboard.server.dao.model.ModelConstants;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = ModelConstants.DEVICE_SHARE_TABLE_NAME)
public final class DeviceShareEntity extends AbstractDeviceShareEntity<DeviceShare> {

    public DeviceShareEntity() {
        super();
    }

    public DeviceShareEntity(DeviceShare deviceShare) {
        super(deviceShare);
        
    }

    @Override
    public DeviceShare toData() {
        return super.toDeviceShare();
    }
}