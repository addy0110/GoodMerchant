package com.example.goodmerchant;

import android.os.Bundle;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import androidx.lifecycle.SavedStateHandle;
import androidx.navigation.NavArgs;
import com.example.goodmerchant.Retrofit.productModal;
import java.io.Serializable;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class ProductDetailFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private ProductDetailFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private ProductDetailFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ProductDetailFragmentArgs fromBundle(@NonNull Bundle bundle) {
    ProductDetailFragmentArgs __result = new ProductDetailFragmentArgs();
    bundle.setClassLoader(ProductDetailFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("productInformation")) {
      productModal productInformation;
      if (Parcelable.class.isAssignableFrom(productModal.class) || Serializable.class.isAssignableFrom(productModal.class)) {
        productInformation = (productModal) bundle.get("productInformation");
      } else {
        throw new UnsupportedOperationException(productModal.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
      if (productInformation == null) {
        throw new IllegalArgumentException("Argument \"productInformation\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("productInformation", productInformation);
    } else {
      throw new IllegalArgumentException("Required argument \"productInformation\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static ProductDetailFragmentArgs fromSavedStateHandle(
      @NonNull SavedStateHandle savedStateHandle) {
    ProductDetailFragmentArgs __result = new ProductDetailFragmentArgs();
    if (savedStateHandle.contains("productInformation")) {
      productModal productInformation;
      productInformation = savedStateHandle.get("productInformation");
      if (productInformation == null) {
        throw new IllegalArgumentException("Argument \"productInformation\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("productInformation", productInformation);
    } else {
      throw new IllegalArgumentException("Required argument \"productInformation\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public productModal getProductInformation() {
    return (productModal) arguments.get("productInformation");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
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

  @SuppressWarnings("unchecked")
  @NonNull
  public SavedStateHandle toSavedStateHandle() {
    SavedStateHandle __result = new SavedStateHandle();
    if (arguments.containsKey("productInformation")) {
      productModal productInformation = (productModal) arguments.get("productInformation");
      if (Parcelable.class.isAssignableFrom(productModal.class) || productInformation == null) {
        __result.set("productInformation", Parcelable.class.cast(productInformation));
      } else if (Serializable.class.isAssignableFrom(productModal.class)) {
        __result.set("productInformation", Serializable.class.cast(productInformation));
      } else {
        throw new UnsupportedOperationException(productModal.class.getName() + " must implement Parcelable or Serializable or must be an Enum.");
      }
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
    ProductDetailFragmentArgs that = (ProductDetailFragmentArgs) object;
    if (arguments.containsKey("productInformation") != that.arguments.containsKey("productInformation")) {
      return false;
    }
    if (getProductInformation() != null ? !getProductInformation().equals(that.getProductInformation()) : that.getProductInformation() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + (getProductInformation() != null ? getProductInformation().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ProductDetailFragmentArgs{"
        + "productInformation=" + getProductInformation()
        + "}";
  }

  public static final class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(@NonNull ProductDetailFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull productModal productInformation) {
      if (productInformation == null) {
        throw new IllegalArgumentException("Argument \"productInformation\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("productInformation", productInformation);
    }

    @NonNull
    public ProductDetailFragmentArgs build() {
      ProductDetailFragmentArgs result = new ProductDetailFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setProductInformation(@NonNull productModal productInformation) {
      if (productInformation == null) {
        throw new IllegalArgumentException("Argument \"productInformation\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("productInformation", productInformation);
      return this;
    }

    @SuppressWarnings({"unchecked","GetterOnBuilder"})
    @NonNull
    public productModal getProductInformation() {
      return (productModal) arguments.get("productInformation");
    }
  }
}
