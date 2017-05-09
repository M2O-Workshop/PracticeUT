/**
 * Copyright 2017 EIS Co., Ltd. All rights reserved.
 */

package sample;

import java.math.BigDecimal;

/**
 * @author 水元 <br />
 *         支払金額計算クラス <br />
 *         定価、会員、割引情報を取得し、最終的な支払金額を計算する <br />
 *         更新履歴 2017/04/05 水元：新規作成 <br />
 */
public class PriceCheck {
  // 消費税込
  public static final String TAX = "1.08";

  /**
   * 金額計算メソッド <br />
   * 定価、会員、割引情報を取得し、最終的な支払金額を計算する <br />
   * 
   * @param price 定価
   * @param member 会員（true：会員、false：非会員）
   * @param discount 割引（"0"：0%、"1"：5%、"2"：10%、"3"：20%、その他：0%）
   * @throws Exception 例外
   * @return total 支払金額
   */
  static BigDecimal priceCal( BigDecimal price, boolean member, String discount )
      throws Exception {
    // 支払い金額格納用
    BigDecimal payment = new BigDecimal( 0 );

    // 割引の種類で条件分岐
    if ( discount.equals( "0" ) ) {
      payment = price;

    } else if ( discount.equals( "1" ) ) {
      payment = price.multiply( new BigDecimal( "0.95" ) );

    } else if ( discount.equals( "2" ) ) {
      payment = price.multiply( new BigDecimal( "0.90" ) );

    } else if ( discount.equals( "3" ) ) {
      payment = price.multiply( new BigDecimal( "0.80" ) );

    } else {
      payment = price;
    }

    // 会員の場合、消費税カット
    if ( !member ) {
      payment = payment.multiply( new BigDecimal( TAX ) );
    }

    // 最終的な支払金額を返す（小数点以下は繰り上げ）
    return payment.setScale( 0, BigDecimal.ROUND_UP );
  }
}
