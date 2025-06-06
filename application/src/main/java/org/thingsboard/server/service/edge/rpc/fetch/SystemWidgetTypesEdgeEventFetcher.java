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
package org.thingsboard.server.service.edge.rpc.fetch;

import lombok.extern.slf4j.Slf4j;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageData;
import org.thingsboard.server.common.data.page.PageLink;
import org.thingsboard.server.common.data.widget.DeprecatedFilter;
import org.thingsboard.server.common.data.widget.WidgetTypeFilter;
import org.thingsboard.server.common.data.widget.WidgetTypeInfo;
import org.thingsboard.server.dao.widget.WidgetTypeService;

@Slf4j
public class SystemWidgetTypesEdgeEventFetcher extends BaseWidgetTypesEdgeEventFetcher {

    public SystemWidgetTypesEdgeEventFetcher(WidgetTypeService widgetTypeService) {
        super(widgetTypeService);
    }

    @Override
    protected PageData<WidgetTypeInfo> findWidgetTypes(TenantId tenantId, PageLink pageLink) {
        return widgetTypeService.findSystemWidgetTypesByPageLink(
                WidgetTypeFilter.builder()
                        .tenantId(tenantId)
                        .fullSearch(false)
                        .deprecatedFilter(DeprecatedFilter.ALL)
                        .widgetTypes(null).build(),
                pageLink);
    }
}
