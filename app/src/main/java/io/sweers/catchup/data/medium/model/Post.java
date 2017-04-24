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

package io.sweers.catchup.data.medium.model;

import android.support.annotation.NonNull;

import com.google.auto.value.AutoValue;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.Moshi;

import org.threeten.bp.Instant;

@AutoValue
public abstract class Post {
  public static JsonAdapter<Post> jsonAdapter(@NonNull Moshi moshi) {
    return new AutoValue_Post.MoshiJsonAdapter(moshi);
  }

  public abstract Instant createdAt();

  public abstract String creatorId();

  public abstract String homeCollectionId();

  public abstract String id();

  public abstract String title();

  public abstract String uniqueSlug();

  public abstract Virtuals virtuals();
}
