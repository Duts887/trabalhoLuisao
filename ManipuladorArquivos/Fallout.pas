type
  ficha = record
      nome : string[40];
      idade : integer;
      peso : real;
    end;

var ficha_arq : file of ficha;
    fichario : array[1..3] of ficha;
    i : integer;

procedure imprime_ficha(pos : integer);
begin
  writeln('Ficha ', pos);
  writeln('Nome: ', fichario[pos].nome);
  writeln('Idade: ', fichario[pos].idade);
  writeln('Peso: ', fichario[pos].peso);
  writeln;
end;

procedure le_e_imprime_ficha(pos : integer);
begin
  assign(ficha_arq, 'ficha_2.dat');
  reset(ficha_arq);
  seek(ficha_arq, pos-1);          { Varia de 0 a n-1 }
  read(ficha_arq, fichario[pos]);  { Varia de 1 a n }
  close(ficha_arq);

  imprime_ficha(pos);
end;

begin
  le_e_imprime_ficha(2);
end.