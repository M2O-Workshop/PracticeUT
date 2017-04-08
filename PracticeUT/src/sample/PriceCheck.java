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
  // 消費税
  public static final String TAX = "1.08";
  
  /**
   * 金額決定クラス <br />
   * 金額、会員情報、クーポン情報を取得し、最終的な請求金額を決定する <br />
   * @param args 起動時引数
   * @throws Exception 例外
   * @return price 金額
   */
  public static BigDecimal priceReturn()throws Exception {
    // 金額を取得
    BigDecimal price = new BigDecimal( priceGet() );
    
    // 会員チェック
    boolean member = memberCheck();
    
    // 割引クーポンチェック
    String coupon = couponCheck();
    
    // クーポンの種類によって割引
    switch (coupon) {
      case "0":
        break;
      case "1":
        price = price.multiply(new BigDecimal("0.95"));
        break;
      case "2":
        price = price.multiply(new BigDecimal("0.90"));
        break;
      case "3":
        price = price.multiply(new BigDecimal("0.80"));
        break;
      default:
        break;
    }
    
    // 会員の場合、消費税カット
    if (!member) {
      price = price.multiply( new BigDecimal(TAX) );
    }
    
    // 最終的な金額を返す
    return price.setScale(0, BigDecimal.ROUND_UP);
  }
  
  /**
   * 合計金額チェックメソッド <br />
   * 商品の合計金額（税抜）を返す <br />
   * @return price 金額
   */
  public static String priceGet() {
    // 金額を返却
    String price = "10000";
    return price;
  }
  
  /**
   * 会員チェックメソッド <br />
   * 会員かどうかを確認し、結果を返す <br />
   * @return member 会員チェック
   */
  public static boolean memberCheck() {
    // 会員かどうかを返す
    // true：会員
    // false：ゲスト
    boolean member = true;
    return member;
  }
  
  /**
   * クーポン使用チェックメソッド <br />
   * クーポンの使用を確認し、結果を返す <br />
   * @return coupoNum クーポン番号
   */
  public static String couponCheck() {
    // クーポンの種類を返す
    // 1：5%OFF
    // 2：10%OFF
    // 3：20%OFF
    String coupoNum = "1";
    return coupoNum;
  }
}
