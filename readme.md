# Сортировка слиянием [Focus Start]

Программа выполняет сортировку слиянием одного или более файлов 
Аргументы сортировки задаютсь при запуске программы из консоли 
в следующем формате:
		
`-[sort order] -[sort type] outputFile.txt inputFile1.txt inputFile2.txt ...`, где `[sort order]` - порядок сортировки , `-a` по возрастанию, 
либо `-d` по убыванию, по умолчанию производится сортировка по возрастанию.

`[sort type] `- тип данных, над которыми ведется сортировка,
`-i Integer, -s String`.

`output.txt` - выходной файл, если нет, создасться автоматически.

`input1.txt`, `input2.txt` .. файлы из которых ведется считывание,
их может быть любое количество.

За правильность введенных данных отвечает пользователь,
при неправильном вводе выведется название ошибки,
и программа завершит работу.
