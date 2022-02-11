package com.example.goodmerchant.Recyclerview;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.example.goodmerchant.Retrofit.productModal;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.lang.System;
import java.util.HashMap;

public class ListFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ListFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private ListFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ListFragmentArgs fromBundle(@NonNull Bundle bundle) {
    ListFragmentArgs __result = new ListFragmentArgs();
    bundle.setClassLoader(ListFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("productDetailList")) {
      productModal[] productDetailList;
      Parcelable[] __array = bundle.getParcelableArray("productDetailList");
      if (__array != null) {
        productDetailList = new productModal[__array.length];
        System.arraycopy(__array, 0, productDetailList, 0, __array.length);
      } else {
        productDetailList = null;
      }
      if (productDetailList == null) {
        throw new IllegalArgumentException("Argument \"productDetailList\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("productDetailList", productDetailList);
    } else {
      throw new IllegalArgumentException("Required argument \"productDetailList\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ListFragmentArgs fromSavedStateHandle(@NonNull SavedStateHandle savedStateHandle) {
    ListFragmentArgs __result = new ListFragmentArgs();
    if (savedStateHandle.contains("productDetailList")) {
      productModal[] productDetailList;
      productDetailList = savedStateHandle.get("productDetailList");
      if (productDetailList == null) {
        throw new IllegalArgumentException("Argument \"productDetailList\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("productDetailList", productDetailList);
    } else {
      throw new IllegalArgumentException("Required argument \"productDetailList\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public productModal[] getProductDetailList() {
    return (productModal[]) arguments.get("productDetailList");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("productDetailList")) {
      productModal[] productDetailList = (productModal[]) arguments.get("productDetailList");
      __result.putParcelableArray("productDetailList", productDetailList);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("productDetailList")) {
      productModal[] productDetailList = (productModal[]) arguments.get("productDetailList");
      __result.set("productDetailList", productDetailList);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    ListFragmentArgs that = (ListFragmentArgs) object;
    if (arguments.containsKey("productDetailList") != that.arguments.containsKey("productDetailList")) {
      return false;
    }
    if (getProductDetailList() != null ? !getProductDetailList().equals(that.getProductDetailList()) : that.getProductDetailList() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + java.util.Arrays.hashCode(getProductDetailList());
    return result;
  }

  @Override
  public String toString() {
    return "ListFragmentArgs{"
        + "productDetailList=" + getProductDetailList()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull ListFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull productModal[] productDetailList) {
      if (productDetailList == null) {
        throw new IllegalArgumentException("Argument \"productDetailList\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("productDetailList", productDetailList);
    }

    @NonNull
    public ListFragmentArgs build() {
      ListFragmentArgs result = new ListFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setProductDetailList(@NonNull productModal[] productDetailList) {
      if (productDetailList == null) {
        throw new IllegalArgumentException("Argument \"productDetailList\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("productDetailList", productDetailList);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public productModal[] getProductDetailList() {
      return (productModal[]) arguments.get("productDetailList");
    }
  }
}
