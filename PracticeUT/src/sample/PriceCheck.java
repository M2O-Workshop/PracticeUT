/**
 * Copyright 2017 EIS Co., Ltd. All rights reserved.
 */
package sample;

import java.math.BigDecimal;

/**
 * @author 水元 <br />
 *  金額決定クラス <br />
 *  金額、会員情報、クーポン情報を取得し、最終的な請求金額を決定する <br />
 *  更新履歴 2017/04/05 水元：新規作成 <br />
 */
public class PriceCheck {
  // 金額
  private BigDecimal price;
  // 会員チェック
  private boolean member;
  // クーポン番号
  private String coupon;
  // 消費税込
  private String tax;
  
  /**
   * 値設定コンストラクタ <br />
   * 処理に使用するオブジェクトに値を設定する <br />
   */
  PriceCheck() {
    this.price = new BigDecimal("100000");
    this.member = true;
    this.coupon = "2";
    this.tax = "1.08";
  }
  
  /**
   * 金額決定クラス <br />
   * 金額、会員情報、クーポン情報を取得し、最終的な請求金額を決定する <br />
   * @throws Exception 例外
   * @return price 金額
   */
  public static BigDecimal priceReturn()throws Exception {
    // 返り値格納用
    BigDecimal finalPrice = new BigDecimal(0);
    // コンストラクタの取得
    PriceCheck priceCheck = new PriceCheck();
    // クーポンの種類によって割引
    switch (priceCheck.coupon) {
      case "0":
        break;
      case "1":
        finalPrice = priceCheck.price.multiply(new BigDecimal("0.95"));
        break;
      case "2":
        finalPrice = priceCheck.price.multiply(new BigDecimal("0.90"));
        break;
      case "3":
        finalPrice = priceCheck.price.multiply(new BigDecimal("0.80"));
        break;
      default:
        break;
    }
    
    // 会員の場合、消費税カット
    if (!priceCheck.member) {
      finalPrice = finalPrice.multiply( new BigDecimal(priceCheck.tax) );
    }
    
    // 最終的な金額を返す（小数点以下は繰り上げ）
    return finalPrice.setScale(0, BigDecimal.ROUND_UP);
  }
}
