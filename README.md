# Funcionalidades adicionales

13. Obtener un listado de todos los productos en promoción de un determinado vendedor y ordenarlos por fecha ascendente y descendente.

Sign:

| Method | Sign |
| --- | --- |
| Get      | **Ejemplos:**  <br/> &nbsp;&nbsp;&nbsp; /products/followed/{userId}/list?order=date_asc <br/>  &nbsp;&nbsp;&nbsp; /products/followed/{userId}/list?order=date_desc | 


| Order | Description |
| --- | --- |
| date_asc      | Fecha ascendente (de más antigua a más nueva) | 
| date_desc     | Fecha descendente (de más nueva a más antigua)|


14. Obtener un listado de todos los productos en promoción de un determinado vendedor y ordenarlos por porcentaje de descuento.

Sign:

| Method | Sign |
| --- | --- |
| Get      | **Ejemplos:**  <br/> &nbsp;&nbsp;&nbsp; /products/followed/{userId}/list?order=discount_asc <br/>  &nbsp;&nbsp;&nbsp; /products/followed/{userId}/list?order=discount_desc | 


| Order | Description |
| --- | --- |
| discount_asc      | Descuento ascendente (de menor porcentaje a mayor) | 
| discount_desc     | Descuento descendente (de mayor porcentaje a menor )|
