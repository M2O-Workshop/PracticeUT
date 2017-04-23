/**
 * Copyright 2017 EIS Co., Ltd. All rights reserved.
 */

package sample;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.math.BigDecimal;

import org.junit.Test;

/**
 * @author ���� <br>
 * ���z����e�X�g�N���X <br>
 * �����N�[�|���A������T�̗L���ŋ��z�����肷�� <br>
 * �X�V���� 2017/04/05 �����F�V�K�쐬 <br>
 */
public class PriceCheckTest {
  /**
   * �e�X�g�P�[�X1 <br>
   * ���z�F100,000
   * ������T�Ftrue�i����j
   * �N�[�|���F0�i�Ȃ��j <br>
   * @throws Exception ��O
   */
  @Test
  public void testCase1() throws Exception {
    // �e�X�g�ΏۃN���X�̃R���X�g���N�^�̐ݒ�
    PriceCheck sut = new PriceCheck( new BigDecimal( "100000" ), true, "0" );
    // �e�X�g�ΏۃN���X�̎��s
    BigDecimal actual = sut.priceReturn();
    // �����l�Ɗ��Ғl���r
    assertThat( actual, is( new BigDecimal( "100000" ) ) );
    // �e�X�g��̌㏈��
    // �㏈���̕K�v�Ȃ�
  }

  /**
   * �e�X�g�P�[�X2 <br>
   * ���z�F123,456
   * ������T�Ftrue�i����j
   * �N�[�|���F1�i5%OFF�j <br>
   * @throws Exception ��O
   */
  @Test
  public void testCase2() throws Exception {
    // �e�X�g�ΏۃN���X�̃R���X�g���N�^�̐ݒ�
    PriceCheck sut = new PriceCheck( new BigDecimal( "123456" ), true, "1" );
    // �e�X�g�ΏۃN���X�̎��s
    BigDecimal actual = sut.priceReturn();
    // �����l�Ɗ��Ғl���r�i�����_�ȉ��̌J��グ���m�F�j
    assertThat( actual, is( new BigDecimal( "117284" ) ) );
    // �e�X�g��̌㏈��
    // �㏈���̕K�v�Ȃ�
  }
}
