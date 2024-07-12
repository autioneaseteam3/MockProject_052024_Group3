import { Injectable, NotFoundException } from '@nestjs/common';
import { Prisma } from '@prisma/client';
import { PrismaService } from 'src/prisma/prisma.service';

@Injectable()
export class BaseService<Model, CreateDTO, UpdateDTO> {
  private readonly model: string;
  private readonly pluralModelName: string;
  private readonly modelId: string;

  constructor(
    protected readonly prisma: PrismaService,
    model: Prisma.ModelName,
  ) {
    this.model = model.toLocaleLowerCase();
    this.pluralModelName = model.toLocaleLowerCase();
    this.modelId = model.toLocaleLowerCase().slice(0, model.length - 1) + 'ID';
  }

  findAll(): Promise<Model[]> {
    return this.prisma[this.model].findMany();
  }

  async findOne(id: number): Promise<Model> {
    const data = await this.prisma[this.model].findUnique({
      where: {
        [this.modelId]: id,
      },
    });

    if (!data)
      throw new NotFoundException(
        `No ${this.pluralModelName} found with this id`,
      );

    return data;
  }

  create(dto: CreateDTO): Promise<Model> {
    return this.prisma[this.model].create({
      data: dto,
    });
  }

  async update(id: number, dto: UpdateDTO): Promise<Model> {
    const updatedData = await this.prisma[this.model].update({
      where: {
        [this.modelId]: id,
      },
      data: dto,
    });

    return updatedData;
  }

  async delete(id: number): Promise<null> {
    await this.prisma[this.model].delete({
      where: {
        [this.modelId]: id,
      },
    });

    return null;
  }
}
