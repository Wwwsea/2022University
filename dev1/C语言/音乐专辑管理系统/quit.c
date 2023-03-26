void Quit()
{
	//退出程序或重新进入主菜单
	char ch;
	printf("\n\t ");
	for (int i = 0; i < 50; i++)
	{
		printf("* ");
		Sleep(10);
	}
	printf("\n\n\t\t\t\t要返回登录界面按任意键\t\t退出并保存数据请按Esc键\n");
	ch = getchar();
	if (ch == 27)	//esc键按下
	{
		SaveData();
		exit(0);
	}
	//重新进入主菜单
	Menu();
}
