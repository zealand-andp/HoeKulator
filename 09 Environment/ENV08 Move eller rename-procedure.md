# Move eller rename-procedure
1. Move og rename benytter den samme kommando. Når man omdøber en fil, flytter man teknisk set filen til en ny sti.
2. Windows stier bruger backslash ( `\` ) hvor Linux bruger forwardslash ( `/` )
3. Stierne skal omsluttes med anførselstegn ( `""` ) hvis de indeholder mellemrum.
4. Stierne skal indeholde filtype.
6. Filer kan omdøbes og flyttes samtidig.
7. Der kan kun flyttes til en mappe der allerede eksisterer.
8. Der kan flyttes og omdøbes hele mapper.

## Eksempel på move
`git mv "01 Business Modeling\AD01 Beregn omsætning.vsdx" "02 Requirements & Analysis\AD01 Beregn omsætning.vsdx"`

## Eksempel på rename
`git mv "02 Requirements & Analysis\Beregn omsætning.vsdx" "02 Requirements & Analysis\AD01 Beregn omsætning.vsdx"`

## Eksempel på move og rename samtidig
`git mv "01 Business Modeling\Beregn omsætning.vsdx" "02 Requirements & Analysis\AD01 Beregn omsætning.vsdx"`