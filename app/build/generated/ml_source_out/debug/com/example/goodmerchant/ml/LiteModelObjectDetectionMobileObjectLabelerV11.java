package com.example.goodmerchant.ml;

import android.content.Context;
import androidx.annotation.NonNull;
import java.io.IOException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.String;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.common.FileUtil;
import org.tensorflow.lite.support.common.TensorProcessor;
import org.tensorflow.lite.support.common.ops.CastOp;
import org.tensorflow.lite.support.common.ops.DequantizeOp;
import org.tensorflow.lite.support.common.ops.NormalizeOp;
import org.tensorflow.lite.support.common.ops.QuantizeOp;
import org.tensorflow.lite.support.image.ImageProcessor;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.image.ops.ResizeOp;
import org.tensorflow.lite.support.image.ops.ResizeOp.ResizeMethod;
import org.tensorflow.lite.support.label.Category;
import org.tensorflow.lite.support.label.TensorLabel;
import org.tensorflow.lite.support.metadata.MetadataExtractor;
import org.tensorflow.lite.support.model.Model;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

/**
 * Mobile
 */
public final class LiteModelObjectDetectionMobileObjectLabelerV11 {
  @NonNull
  private final ImageProcessor imageProcessor;

  private int imageHeight;

  private int imageWidth;

  @NonNull
  private final List<String> probabilityLabelsEn;

  @NonNull
  private final TensorProcessor probabilityPostProcessor;

  @NonNull
  private final Model model;

  private LiteModelObjectDetectionMobileObjectLabelerV11(@NonNull Context context,
      @NonNull Model.Options options) throws IOException {
    model = Model.createModel(context, "lite-model_object_detection_mobile_object_labeler_v1_1.tflite", options);
    MetadataExtractor extractor = new MetadataExtractor(model.getData());
    ImageProcessor.Builder imageProcessorBuilder = new ImageProcessor.Builder()
      .add(new ResizeOp(224, 224, ResizeMethod.NEAREST_NEIGHBOR))
      .add(new NormalizeOp(new float[] {127.5f}, new float[] {127.5f}))
      .add(new QuantizeOp(128f, 0.007843138f))
      .add(new CastOp(DataType.UINT8));
    imageProcessor = imageProcessorBuilder.build();
    TensorProcessor.Builder probabilityPostProcessorBuilder = new TensorProcessor.Builder()
      .add(new DequantizeOp((float)0, (float)0.00390625))
      .add(new NormalizeOp(new float[] {0.0f}, new float[] {1.0f}));
    probabilityPostProcessor = probabilityPostProcessorBuilder.build();
    probabilityLabelsEn = FileUtil.loadLabels(extractor.getAssociatedFile("probability-labels-en.txt"));
  }

  @NonNull
  public static LiteModelObjectDetectionMobileObjectLabelerV11 newInstance(@NonNull Context context)
      throws IOException {
    return new LiteModelObjectDetectionMobileObjectLabelerV11(context, (new Model.Options.Builder()).build());
  }

  @NonNull
  public static LiteModelObjectDetectionMobileObjectLabelerV11 newInstance(@NonNull Context context,
      @NonNull Model.Options options) throws IOException {
    return new LiteModelObjectDetectionMobileObjectLabelerV11(context, options);
  }

  @NonNull
  public Outputs process(@NonNull TensorImage image) {
    imageHeight = image.getHeight();
    imageWidth = image.getWidth();
    TensorImage processedimage = imageProcessor.process(image);
    Outputs outputs = new Outputs(model);
    model.run(new Object[] {processedimage.getBuffer()}, outputs.getBuffer());
    return outputs;
  }

  public void close() {
    model.close();
  }

  @NonNull
  public Outputs process(@NonNull TensorBuffer image) {
    TensorBuffer processedimage = image;
    Outputs outputs = new Outputs(model);
    model.run(new Object[] {processedimage.getBuffer()}, outputs.getBuffer());
    return outputs;
  }

  public class Outputs {
    private TensorBuffer probability;

    private Outputs(Model model) {
      this.probability = TensorBuffer.createFixedSize(model.getOutputTensorShape(0), DataType.UINT8);
    }

    @NonNull
    public List<Category> getProbabilityAsCategoryList() {
      return new TensorLabel(probabilityLabelsEn, probabilityPostProcessor.process(probability)).getCategoryList();
    }

    @NonNull
    public TensorBuffer getProbabilityAsTensorBuffer() {
      return probabilityPostProcessor.process(probability);
    }

    @NonNull
    private Map<Integer, Object> getBuffer() {
      Map<Integer, Object> outputs = new HashMap<>();
      outputs.put(0, probability.getBuffer());
      return outputs;
    }
  }
}
