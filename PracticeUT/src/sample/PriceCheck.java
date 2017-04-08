/**
 * Copyright 2017 EIS Co., Ltd. All rights reserved.
 */
package sample;

import java.math.BigDecimal;

/**
 * @author ���� <br />
 *  ���z����N���X <br />
 *  ���z�A������A�N�[�|�������擾���A�ŏI�I�Ȑ������z�����肷�� <br />
 *  �X�V���� 2017/04/05 �����F�V�K�쐬 <br />
 */
public class PriceCheck {
  // �����
  public static final String TAX = "1.08";
  
  /**
   * ���z����N���X <br />
   * ���z�A������A�N�[�|�������擾���A�ŏI�I�Ȑ������z�����肷�� <br />
   * @param args �N��������
   * @throws Exception ��O
   * @return price ���z
   */
  public static BigDecimal priceReturn()throws Exception {
    // ���z���擾
    BigDecimal price = new BigDecimal( priceGet() );
    
    // ����`�F�b�N
    boolean member = memberCheck();
    
    // �����N�[�|���`�F�b�N
    String coupon = couponCheck();
    
    // �N�[�|���̎�ނɂ���Ċ���
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
    
    // ����̏ꍇ�A����ŃJ�b�g
    if (!member) {
      price = price.multiply( new BigDecimal(TAX) );
    }
    
    // �ŏI�I�ȋ��z��Ԃ�
    return price.setScale(0, BigDecimal.ROUND_UP);
  }
  
  /**
   * ���v���z�`�F�b�N���\�b�h <br />
   * ���i�̍��v���z�i�Ŕ��j��Ԃ� <br />
   * @return price ���z
   */
  public static String priceGet() {
    // ���z��ԋp
    String price = "10000";
    return price;
  }
  
  /**
   * ����`�F�b�N���\�b�h <br />
   * ������ǂ������m�F���A���ʂ�Ԃ� <br />
   * @return member ����`�F�b�N
   */
  public static boolean memberCheck() {
    // ������ǂ�����Ԃ�
    // true�F���
    // false�F�Q�X�g
    boolean member = true;
    return member;
  }
  
  /**
   * �N�[�|���g�p�`�F�b�N���\�b�h <br />
   * �N�[�|���̎g�p���m�F���A���ʂ�Ԃ� <br />
   * @return coupoNum �N�[�|���ԍ�
   */
  public static String couponCheck() {
    // �N�[�|���̎�ނ�Ԃ�
    // 1�F5%OFF
    // 2�F10%OFF
    // 3�F20%OFF
    String coupoNum = "1";
    return coupoNum;
  }
}
