void Quit()
{
	//�˳���������½������˵�
	char ch;
	printf("\n\t ");
	for (int i = 0; i < 50; i++)
	{
		printf("* ");
		Sleep(10);
	}
	printf("\n\n\t\t\t\tҪ���ص�¼���水�����\t\t�˳������������밴Esc��\n");
	ch = getchar();
	if (ch == 27)	//esc������
	{
		SaveData();
		exit(0);
	}
	//���½������˵�
	Menu();
}
