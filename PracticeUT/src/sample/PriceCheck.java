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
  // ���z
  private BigDecimal price;
  // ����`�F�b�N
  private boolean member;
  // �N�[�|���ԍ�
  private String coupon;
  // ����ō�
  private String tax;
  
  /**
   * �l�ݒ�R���X�g���N�^ <br />
   * �����Ɏg�p����I�u�W�F�N�g�ɒl��ݒ肷�� <br />
   */
  PriceCheck() {
    this.price = new BigDecimal("100000");
    this.member = true;
    this.coupon = "2";
    this.tax = "1.08";
  }
  
  /**
   * ���z����N���X <br />
   * ���z�A������A�N�[�|�������擾���A�ŏI�I�Ȑ������z�����肷�� <br />
   * @throws Exception ��O
   * @return price ���z
   */
  public static BigDecimal priceReturn()throws Exception {
    // �Ԃ�l�i�[�p
    BigDecimal finalPrice = new BigDecimal(0);
    // �R���X�g���N�^�̎擾
    PriceCheck priceCheck = new PriceCheck();
    // �N�[�|���̎�ނɂ���Ċ���
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
    
    // ����̏ꍇ�A����ŃJ�b�g
    if (!priceCheck.member) {
      finalPrice = finalPrice.multiply( new BigDecimal(priceCheck.tax) );
    }
    
    // �ŏI�I�ȋ��z��Ԃ��i�����_�ȉ��͌J��グ�j
    return finalPrice.setScale(0, BigDecimal.ROUND_UP);
  }
}
