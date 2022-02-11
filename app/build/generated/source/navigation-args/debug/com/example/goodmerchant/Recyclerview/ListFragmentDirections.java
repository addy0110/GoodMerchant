package com.example.goodmerchant.Recyclerview;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.navigation.ActionOnlyNavDirections;
import androidx.navigation.NavDirections;
import com.example.goodmerchant.R;
import com.example.goodmerchant.Retrofit.productModal;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ListFragmentDirections {
  private ListFragmentDirections() {
  }

  @NonNull
  public static ActionListFragmentToProductDetailFragment actionListFragmentToProductDetailFragment(
      @NonNull productModal productInformation) {
    return new ActionListFragmentToProductDetailFragment(productInformation);
  }

  @NonNull
  public static NavDirections actionListFragmentToMainFragment() {
    return new ActionOnlyNavDirections(R.id.action_listFragment_to_mainFragment);
  }

  public static class ActionListFragmentToProductDetailFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionListFragmentToProductDetailFragment(@NonNull productModal productInformation) {
      if (productInformation == null) {
        throw new IllegalArgumentException("Argument \"productInformation\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("productInformation", productInformation);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionListFragmentToProductDetailFragment setProductInformation(
        @NonNull productModal productInformation) {
      if (productInformation == null) {
        throw new IllegalArgumentException("Argument \"productInformation\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("productInformation", productInformation);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
      Bundle __result = new Bundle();
      if (arguments.containsKey("productInformation")) {
        productModal productInformation = (productModal) arguments.get("productInformation");
        if (Parcelable.class.isAssignableFrom(productModal.class) || productInformation == null) {
          __result.putParcelable("productInformation", Parcelable.class.cast(productInformation));
        } else if (Serializable.class.isAssignableFrom(productModal.class)) {
          __result.putSerializable("productInformation", Serializable.class.cast(productInformation));
        } else {
          throw new UnsupportedOperationException(productModal.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
        }
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_listFragment_to_productDetailFragment;
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public productModal getProductInformation() {
      return (productModal) arguments.get("productInformation");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionListFragmentToProductDetailFragment that = (ActionListFragmentToProductDetailFragment) object;
      if (arguments.containsKey("productInformation") != that.arguments.containsKey("productInformation")) {
        return false;
      }
      if (getProductInformation() != null ? !getProductInformation().equals(that.getProductInformation()) : that.getProductInformation() != null) {
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
      result = 31 * result + (getProductInformation() != null ? getProductInformation().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionListFragmentToProductDetailFragment(actionId=" + getActionId() + "){"
          + "productInformation=" + getProductInformation()
          + "}";
    }
  }
}
