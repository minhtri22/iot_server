///
/// Copyright © 2016-2025 The Thingsboard Authors
///
/// Licensed under the Apache License, Version 2.0 (the "License");
/// you may not use this file except in compliance with the License.
/// You may obtain a copy of the License at
///
///     http://www.apache.org/licenses/LICENSE-2.0
///
/// Unless required by applicable law or agreed to in writing, software
/// distributed under the License is distributed on an "AS IS" BASIS,
/// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
/// See the License for the specific language governing permissions and
/// limitations under the License.
///

import { Component, Inject, OnInit, SkipSelf } from '@angular/core';
import { ErrorStateMatcher } from '@angular/material/core';
import { MAT_DIALOG_DATA, MatDialogRef } from '@angular/material/dialog';
import { Store } from '@ngrx/store';
import { AppState } from '@core/core.state';
import { UntypedFormBuilder, UntypedFormControl, UntypedFormGroup, FormGroupDirective, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { DialogComponent } from '@app/shared/components/dialog.component';
import { UtilsService } from '@core/services/utils.service';
import { TranslateService } from '@ngx-translate/core';

export interface EditAlarmDetailsDialogData {
  alarmDetails: string;
  readonly: boolean;
}

@Component({
  selector: 'tb-edit-alarm-details-dialog',
  templateUrl: './edit-alarm-details-dialog.component.html',
  providers: [{provide: ErrorStateMatcher, useExisting: EditAlarmDetailsDialogComponent}],
  styleUrls: []
})
export class EditAlarmDetailsDialogComponent extends DialogComponent<EditAlarmDetailsDialogComponent, string>
  implements OnInit, ErrorStateMatcher {

  alarmDetails = this.data.alarmDetails;

  editDetailsFormGroup: UntypedFormGroup;

  submitted = false;

  constructor(protected store: Store<AppState>,
              protected router: Router,
              @Inject(MAT_DIALOG_DATA) public data: EditAlarmDetailsDialogData,
              @SkipSelf() private errorStateMatcher: ErrorStateMatcher,
              public dialogRef: MatDialogRef<EditAlarmDetailsDialogComponent, string>,
              private fb: UntypedFormBuilder,
              private utils: UtilsService,
              public translate: TranslateService) {
    super(store, router, dialogRef);

    this.editDetailsFormGroup = this.fb.group({
      alarmDetails: [this.alarmDetails]
    });
    if (this.data.readonly) {
      this.editDetailsFormGroup.disable();
    }
  }

  ngOnInit(): void {
  }

  isErrorState(control: UntypedFormControl | null, form: FormGroupDirective | NgForm | null): boolean {
    const originalErrorState = this.errorStateMatcher.isErrorState(control, form);
    const customErrorState = !!(control && control.invalid && this.submitted);
    return originalErrorState || customErrorState;
  }

  cancel(): void {
    this.dialogRef.close(null);
  }

  save(): void {
    this.submitted = true;
    this.alarmDetails = this.editDetailsFormGroup.get('alarmDetails').value;
    this.dialogRef.close(this.alarmDetails);
  }
}
