INSERT INTO FINANCE (id, name, token, request_id, game_code, currency, status, balance)
VALUES ( 1, 'john12345', '55b7518e-b89e-11e7-81be-58404eea6d16', '583c985f-fee6-4c0e-bbf5-308aad6265af'
       , 'clt_dragonrising'
       , 'EUR', 'RS_OK', 10000);

INSERT INTO TRANSACTION (id, name, trans_id, sup_trans_id, token, sup_user,
                         round_closed, round, reward_id, request_id, ref_trans_id, status, is_free,
                         is_aggregated, game_code, currency, bet, amount, balance, pre_Balance)
VALUES (1, 'john12345', '16d2dcfe-b89e-11e7-854a-58404eea6d16', '41ecc3ad-b181-4235-bf9d-acf0a7ad9730',
        '55b7518e-b89e-11e7-81be-58404eea6d16', 'cg_45141', true, 'rNEMwgzJAOZ6eR3V',
        'a28f93f2-98c5-41f7-8fbb-967985acf8fe', '583c985f-fee6-4c0e-bbf5-308aad6265af',
        '16d2dcfe-b89e-11e7-854a-58404eea6d16', 'RS_OK', true, false, 'clt_dragonrising', 'EUR', 'Zero', 100000,
        10000, 0);

INSERT INTO userinfo (id, name, status, request_id, country, jurisdiction, partner_id, DOB, ROB, tags, sex,
                      affiliate_id)
VALUES (1, 'john12345','RS_OK', '583c985f-fee6-4c0e-bbf5-308aad6265af', 'FR', 'MGA', '123_sub', '1980-10-20',
        '2010-10-20',
        'VIP', 'MALE', '124_af');



-- --                          GAME_CODE, IS_AGGREGATED, IS_FREE, PREVIOUS_BALANCE,
-- --                          REFERENCE_TRANSACTION_UUID, REQUEST_UUID, REWARD_UUID, ROUND, ROUND_CLOSED, STATUS,
-- --                          SUPPLIER_TRANSACTION_ID, SUPPLIER_USER, TOKEN, TRANSACTION_UUID, NAME)
-- VALUES (1, 10000, 10000, 'Zero', 'EUR');
-- --   'clt_dragonrising', FALSE, 0, '41ecc3ad-b181-4235-bf9d-acf0a7ad9730',
-- --         '16d2dcfe-b89e-11e7-854a-58404eea6d16', '583c985f-fee6-4c0e-bbf5-308aad6265af',
-- --         'a28f93f2-98c5-41f7-8fbb-967985acf8fe', 'rNEMwgzJAOZ6eR3V', True, 'RS_OK',
-- --         '41ecc3ad-b181-4235-bf9d-acf0a7ad9730',
-- --         '55b7518e-b89e-11e7-81be-58404eea6d16', '16d2dcfe-b89e-11e7-854a-58404eea6d16', 'john12345');
