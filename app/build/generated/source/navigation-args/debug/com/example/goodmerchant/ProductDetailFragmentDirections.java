package com.example.goodmerchant;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.example.goodmerchant.Retrofit.productModal;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ProductDetailFragmentDirections {
  private ProductDetailFragmentDirections() {
  }

  @NonNull
  public static ActionProductDetailFragmentToListFragment2 actionProductDetailFragmentToListFragment2(
      @NonNull productModal[] productDetailList) {
    return new ActionProductDetailFragmentToListFragment2(productDetailList);
  }

  public static class ActionProductDetailFragmentToListFragment2 implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionProductDetailFragmentToListFragment2(@NonNull productModal[] productDetailList) {
      if (productDetailList == null) {
        throw new IllegalArgumentException("Argument \"productDetailList\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("productDetailList", productDetailList);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionProductDetailFragmentToListFragment2 setProductDetailList(
        @NonNull productModal[] productDetailList) {
      if (productDetailList == null) {
        throw new IllegalArgumentException("Argument \"productDetailList\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("productDetailList", productDetailList);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("productDetailList")) {
        productModal[] productDetailList = (productModal[]) arguments.get("productDetailList");
        __result.putParcelableArray("productDetailList", productDetailList);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_productDetailFragment_to_listFragment2;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public productModal[] getProductDetailList() {
      return (productModal[]) arguments.get("productDetailList");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionProductDetailFragmentToListFragment2 that = (ActionProductDetailFragmentToListFragment2) object;
      if (arguments.containsKey("productDetailList") != that.arguments.containsKey("productDetailList")) {
        return false;
      }
      if (getProductDetailList() != null ? !getProductDetailList().equals(that.getProductDetailList()) : that.getProductDetailList() != null) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + java.util.Arrays.hashCode(getProductDetailList());
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionProductDetailFragmentToListFragment2(actionId=" + getActionId() + "){"
          + "productDetailList=" + getProductDetailList()
          + "}";
    }
  }
}
