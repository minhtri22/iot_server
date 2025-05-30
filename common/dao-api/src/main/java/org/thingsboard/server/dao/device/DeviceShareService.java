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

 package org.thingsboard.server.dao.device; // Chọn package thích hợp

 import org.thingsboard.server.common.data.DeviceShare;
 import org.thingsboard.server.common.data.id.CustomerId;
 import org.thingsboard.server.common.data.id.DeviceId;
 import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.dao.entity.EntityDaoService;

import java.util.List;
import java.util.UUID;
 
 public interface DeviceShareService extends EntityDaoService{
 
     void shareDevice(TenantId tenantId, DeviceId deviceId, CustomerId customerId);
 
     void unshareDevice(TenantId tenantId, UUID id);
 
     List<DeviceShare> getSharedDevicesByCustomerId(TenantId tenantId, CustomerId customerId);
 
     List<DeviceShare> getSharedDevicesByTenantId(TenantId tenantId);
 }