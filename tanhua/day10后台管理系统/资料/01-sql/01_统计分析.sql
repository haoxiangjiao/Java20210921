//�ۼ��û���
SELECT SUM(num_registered) as numRegistered FROM tb_analysis_by_day;

//��ȥ7���Ծ�û�
SELECT SUM(num_active) AS num_active FROM tb_analysis_by_day WHERE record_date <= '2020-09-08' AND record_date >= '2020-09-01'

//��ȥ30���Ծ�û�
SELECT SUM(num_active) AS num_active FROM tb_analysis_by_day WHERE record_date <= '2020-09-08' AND record_date >= '2020-08-09';

//���������û�
SELECT SUM(num_registered) AS num_active FROM tb_analysis_by_day WHERE record_date <= '2020-09-08' AND record_date >= '2020-09-08'

//���յ�¼����
SELECT SUM(num_login) AS num_active FROM tb_analysis_by_day WHERE record_date <= '2020-09-08' AND record_date >='2020-09-08'

//���ջ�Ծ�û�
SELECT SUM(num_active) AS num_active FROM tb_analysis_by_day WHERE record_date <= '2020-09-08' AND record_date >= '2020-09-08'


//�����û���
SELECT record_date , num_registered as num_active FROM tb_analysis_by_day WHERE record_date >= '2021-02-24' AND record_date <= '2021-03-03'
SELECT record_date , num_registered as num_active FROM tb_analysis_by_day WHERE record_date >= '2020-02-24' AND record_date <= '2020-03-03' 

//��Ծ�û�
SELECT record_date , num_active as num_active FROM tb_analysis_by_day WHERE record_date >= '2021-02-24' AND record_date <= '2021-03-03'
SELECT record_date , num_active as num_active FROM tb_analysis_by_day WHERE record_date >= '2020-02-24' AND record_date <= '2020-03-03'

//����������
SELECT record_date , num_retention1d as num_active FROM tb_analysis_by_day WHERE record_date >= '2021-02-24' AND record_date <= '2021-03-03'
SELECT record_date , num_retention1d as num_active FROM tb_analysis_by_day WHERE record_date >= '2020-02-24' AND record_date <= '2020-03-03'
