/**
 * Copyright 2017 EIS Co., Ltd. All rights reserved.
 */
package sample;

import java.math.BigDecimal;

/**
 * @author 水元 <br />
 *  ショッピングクラス <br />
 *  ショッピングを行う際のメインクラス。 <br />
 *  更新履歴 2017/05/03 水元：新規作成 <br />
 */
public class Shop {

  /**
   * ショッピングのメインメソッド <br />
   * ショッピングの機能を呼び出す。 <br />
   * @param args 起動時引数
   * @throws Exception 例外
   */
  public static void main( String[] args ) throws Exception {
    // 支払金額計算クラスを呼び出す。
    // コンストラクタの引数は仮の値。今後外部から入力できるようにする。
    new PriceCheck(new BigDecimal("10000"), true, "1");
    BigDecimal payment = PriceCheck.priceCal();
    System.out.println( payment ); // 動作確認用
  }
}
