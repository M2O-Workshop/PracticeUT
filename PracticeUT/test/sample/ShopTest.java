/**
 * Copyright 2017 EIS Co., Ltd. All rights reserved.
 */
package sample;

import org.junit.Test;

/**
 * @author 水元 <br>
 *  ショッピングテストクラス <br>
 *  ショッピング機能を呼び出す。 <br>
 *  更新履歴 2017/05/03 水元：新規作成 <br>
 */
public class ShopTest {

  /**
   * テストケース1 <br>
   * メインメソッドの正常動作<br>
   * @throws Exception 例外
   */
  @SuppressWarnings("static-access")
  @Test
  public void testCase1() throws Exception {
    // テスト対象クラス
    Shop sut = new Shop();
    // テスト対象クラスの実行
    sut.main(new String[]{});
    // 実測値と期待値を比較:正常動作のため必要なし
    // テスト後の後処理：必要なし
  }

}
