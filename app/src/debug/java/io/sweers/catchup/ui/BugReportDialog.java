/*
 * Copyright (c) 2017 Zac Sweers
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.sweers.catchup.ui;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import io.sweers.catchup.R;
import io.sweers.catchup.ui.BugReportView.Report;

public final class BugReportDialog extends AlertDialog
    implements BugReportView.ReportDetailsListener {
  public interface ReportListener {
    void onBugReportSubmit(Report report);
  }

  private ReportListener listener;

  public BugReportDialog(Context context) {
    super(context);

    final BugReportView view =
        (BugReportView) LayoutInflater.from(context).inflate(R.layout.bugreport_view, null);
    view.setBugReportListener(this);

    setTitle("Report a bug");
    setView(view);
    setButton(Dialog.BUTTON_NEGATIVE, "Cancel", (OnClickListener) null);
    setButton(Dialog.BUTTON_POSITIVE, "Submit", (dialog, which) -> {
      if (listener != null) {
        listener.onBugReportSubmit(view.getReport());
      }
    });
  }

  public void setReportListener(ReportListener listener) {
    this.listener = listener;
  }

  @Override protected void onStart() {
    getButton(Dialog.BUTTON_POSITIVE).setEnabled(false);
  }

  @Override public void onStateChanged(boolean valid) {
    getButton(Dialog.BUTTON_POSITIVE).setEnabled(valid);
  }
}
