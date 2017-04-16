/**
 * Copyright 2017 EIS Co., Ltd. All rights reserved.
 */
package sample;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * @author 水元 <br>
 *  金額決定テストクラス <br>
 *  割引クーポン、会員特典の有無で金額を決定する <br>
 *  更新履歴 2017/04/05 水元：新規作成 <br>
 */
public class PriceCheckTest {
  /**
   * テストケース0 <br>
   * クーポン：2（10%OFF）
   * 会員特典：true（あり） <br>
   * @throws Exception 例外
   */
  @Test
  public void testCase0() throws Exception {
    // 実測値と期待値を比較
    assertThat(PriceCheck.priceReturn(), is(new BigDecimal("90000")));
  }
}
