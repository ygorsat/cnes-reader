import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'enumPipe'
})
export class EnumPipe implements PipeTransform {
  transform(value: string, enumMsg: any): any {
    return enumMsg[value];
  }

}
