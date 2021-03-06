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
 *         金額決定テストクラス <br>
 *         割引、会員特典を考慮した金額を設定する <br>
 *         更新履歴 2017/04/05 水元：新規作成 <br>
 */
public class PriceCheckTest {
  /**
   * テストケース1 <br>
   * 金額計算メソッドの正常動作 定価：100,000 会員：true（あり） 割引：0（なし） <br>
   * 
   * @throws Exception 例外
   */
  @Test
  public void testCase1() throws Exception {
    // テスト前準備：必要なし
    // テスト対象クラスの実行
    BigDecimal actual = PriceCheck.priceCal( new BigDecimal( "100000" ), true, "0" );
    // 実測値と期待値を比較
    assertThat( actual, is( new BigDecimal( "100000" ) ) );
    // テスト後の後処理：必要なし
  }

  /**
   * テストケース2 <br>
   * 金額計算メソッドの正常動作 定価：123,456 会員：true（あり） 割引：1（5%OFF） <br>
   * 
   * @throws Exception 例外
   */
  @Test
  public void testCase2() throws Exception {
    // テスト前準備：必要なし
    // テスト対象クラスの実行
    BigDecimal actual = PriceCheck.priceCal( new BigDecimal( "123456" ), true, "1" );
    // 実測値と期待値を比較（小数点以下の繰り上げを確認）
    assertThat( actual, is( new BigDecimal( "117284" ) ) );
    // テスト後の後処理：必要なし
  }
}
